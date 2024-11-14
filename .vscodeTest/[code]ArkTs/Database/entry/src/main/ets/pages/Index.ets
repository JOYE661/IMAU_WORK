import relationalStore from '@ohos.data.relationalStore'

@Extend(Button) function myButton()
{
  .backgroundColor(0x0080ff)
  .width('90%')
  .height('5%')
  .borderRadius(50)
  .type(ButtonType.Normal)
}

const STORE_CONFIG={
  name:'student.db',
  securityLevel:relationalStore.SecurityLevel.S1
};
const SQL_CREATE_TABLE = 'CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, age INTEGER)';
const MyTAG = '----->';

@Entry
@Component
struct Index {
  @State rdbStore:relationalStore.RdbStore=null
  @State message: string =""
  @State MyTAG:string ='----->'

  aboutToAppear(){
    relationalStore.getRdbStore(getContext(),STORE_CONFIG,(err,store)=>{
      if (err) {
        this.message+=`${this.MyTAG}初始化数据库失败,Failed to get RdbStore.Code :${err.code},message:${err.message}\n`
        console.error(this.message)
        return;
      }

      this.message+=`${this.MyTAG}成功初始化数据,Succeeded in getting RdbStore.\n`
      console.info(this.message)
      this.rdbStore=store;
    })
  }

  build() {
    Scroll(){
      Column({space:15}){
        Text('DataBase').fontSize(40).fontColor(0x0080ff)
        Button('创建数据表').myButton().onClick(()=>{
          this.rdbStore.executeSql(SQL_CREATE_TABLE);
          this.message+=`${this.MyTAG}创建数据表成功\n`
          console.info(this.message)
        })
        Button('插入数据表').myButton().onClick(()=>{
          const valueBucket = {
            'name': '张三',
            'age': 18
          };
          this.rdbStore.insert('student', valueBucket, (err, rowId) => {
            if (err) {
              this.message += `${MyTAG} 插入数据失败. Code:${err.code}, message:${err.message}\n`
              console.error(this.message)
              return;
            }
            this.message += `${MyTAG} 插入数据成功. rowId:${rowId}\n`
            console.info(this.message)
          })
        })
        Button('批量插入').myButton().onClick(()=>{
          let valueBucketList = []
          for (let i = 0;i < 10; i++) {
            let valueBucket = {
              'name': '张三' +i,
              'age': 18+i
            };
            valueBucketList[i] = valueBucket
          }
          this.rdbStore.batchInsert("student", valueBucketList, (err, rowId) => {
            if (err) {
              this.message += `${MyTAG} 批量插入数据失败. Code:${err.code}, message:${err.message}\n`
              console.error(this.message)
              return;
            }
            this.message += `${MyTAG} 批量插入数据成功. rowId:${rowId}\n`
            console.info(this.message)
          })
        })
        Button('修改数据').myButton().onClick(()=>{
          const newValueBucket = {
            'name': '李四',
            'age': 20
          };
          let predicates = new relationalStore.RdbPredicates('student');
          predicates.equalTo('name', '张三');
          this.rdbStore.update(newValueBucket, predicates, (err, rows) => {
            if (err) {
              this.message += `${MyTAG} 更新数据失败. Code:${err.code}, message:${err.message}\n`
              console.error(this.message)
              return;
            }
            this.message += `${MyTAG} 更新数据成功. row count: ${rows}\n`
            console.info(this.message)
          })
        })
        Button('删除数据（先修改）').myButton().onClick(()=>{
          let predicates = new relationalStore.RdbPredicates('student');
          predicates.equalTo('name', '李四');

          this.rdbStore.delete(predicates, (err, rows) => {
            if (err) {
              this.message += `${MyTAG}删除数据失败. Code:${err.code}, message:${err.message}\n`
              console.error(this.message);
              return;
            }
            this.message += `${MyTAG}删除数据成功，Delete rows: ${rows}\n`
            console.info(this.message)
          })
        })
        Button('查询').myButton().onClick(()=>{
          let predicates =new relationalStore.RdbPredicates('student')
          predicates.equalTo('name','张三')
          this.rdbStore.query(predicates,['id','name','age'],(err,resultSet)=>{
            if (err) {
              this.message+=`${MyTAG}条件查询失败. Code:${err.code},message:${err.message}\n`
              console.error(this.message)
              return
            }
            this.parseData(resultSet)
          })
        })
        Button('查询全部').myButton().onClick(()=>{
          let predicates=new relationalStore.RdbPredicates('student')
          this.rdbStore.query(predicates,['id','name','age'],(err,resultSet)=>{
            if (err) {
              this.message+=`${MyTAG}查询全部失败. Code:${err.code},message:${err.message}\n`
              console.error(this.message)
              return
            }
            this.parseData(resultSet)
          })
        })
        Button('删除数据库').myButton().onClick(()=>{
          AlertDialog.show({
            title: "提示",
            message: "确认要删除数据库吗?",
            primaryButton: {
              value: "确认",
              action: () => {
                relationalStore.deleteRdbStore(getContext(), 'student.db', (err) => {
                  if (err) {
                    this.message += `${MyTAG}删除数据库失败. Code:${err.code}, message:${err.message}\n`
                    console.error(this.message);
                    return;
                  }
                  this.message += `${MyTAG}删除数据库成功，Succeeded in deleting RdbStore.\n`
                  console.info(this.message);
                });
              }
            },
            secondaryButton: {
              value: "取消",
              action: () => {
                this.message += `${MyTAG}您点击了取消按钮，取消删除数据库\n`
                console.info(this.message)
              }
            }
          })
        })
        TextArea({text:'执行结果：\r\n'+this.message}).margin({top:10})
      }.width('100%').alignItems(HorizontalAlign.Center)
    }
  }
  parseData(resultSet: relationalStore.ResultSet) {
    console.info(`${this.MyTAG}ResultSet column names:${resultSet.columnNames}\n`);
    console.info(`${this.MyTAG}ResultSet column count:${resultSet.columnCount}\n`);

    let count = resultSet.rowCount
    if (count == 0) {
      this.message += `${this.MyTAG}查询结果为空，count=${count}\n`
      console.info(this.message)
      return
    }
    this.message += `${this.MyTAG}查询成功，count=${count}，开始解析......`
    console.info(this.message)

    resultSet.goToFirstRow() //开始第一条
    for (let i = 0; i < count; i++) {
      let id = resultSet.getDouble(resultSet.getColumnIndex("id"))
      let name = resultSet.getString(resultSet.getColumnIndex("name"))
      let age = resultSet.getDouble(resultSet.getColumnIndex("age"))

      //输出结果看一下
      let msg = `id=${id}, name=${name}, age=${age}`
      this.message += "\r\n" + msg+'\n'
      console.info(this.message)
      //继续下一条
      resultSet.goToNextRow()
    }

    this.message += `${this.MyTAG}查询成功，count=${count}，解析结束.\n`
    console.info(this.message)
  }
}