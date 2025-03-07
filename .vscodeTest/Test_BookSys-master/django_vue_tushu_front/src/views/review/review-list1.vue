<template>
    <el-card shadow="never" style="margin-top: 10px;">
        <!-- 表格区域 -->
        <el-table :data="tableData" stripe>
            <el-table-column prop="id" label="ID" width="70" />
            <el-table-column prop="sqren" label="昵称" width="160" />
            <el-table-column prop="sqliyou" label="申请理由" width="280" />
            <el-table-column prop="shzhuangtai" label="审核状态" width="180">
                <!-- <template #default="scope">
                    {{ statusMap[scope.row.status] || '未知状态' }}
                </template> -->
            </el-table-column>
            <el-table-column prop="cttime" label="创建时间" width="260" />
            <el-table-column prop="mdtime" label="更新时间" width="260" />
            <el-table-column label="操作" width="180" fixed="right">
                <template #default="scope">
                    <el-dropdown @command="handleCommand" trigger="click">
                        <el-button type="primary" @click="er(scope.row)" >审批</el-button>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item divided command="1">同意</el-dropdown-item>
                                <el-dropdown-item divided command="2">拒绝</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                </template>
            </el-table-column>


        </el-table>
        <!-- 分页 -->
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange"
            layout="sizes, total, prev, pager, next" :total="totalNum" :currentPage="search.pageNum"
            :pageSize="search.pageSize">
        </el-pagination>
    </el-card>
</template>
  
<script>
import sDrawer from "@/components/s-drawer/s-drawer.vue"
export default {
    components: {
        sDrawer,
    },
    watch: {
        visible(value) {
            if (!value) {
                this.form = {}
            }
        }
    },
    data() {
        return {
            form: {},
            visible: false,
            tableData: [],
            totalNum: 0,
            search: {
                pageNum: 1,
                pageSize: 10,
                shenhezt: 1
            },
            statusMap: {
                0: '待审核',
                1: '已通过',
                2: '未通过', // 根据您的实际状态码定义对应的中文描述
            },
        };
    },
    created() {
        this.getList();
    },
    methods: {
        async getList() {
            const res = await this.$request.get(
                "/jc/shenpi/",
                { params: this.search }
            );
            if (res.data.code === 200) {
              // 直接对筛选后并排序的数据赋值给 this.tableData
              this.tableData = res.data.data
              this.totalNum = res.data.zs
          }
        },
        // 每页条数改变时触发 选择一页显示多少行
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.search.pageSize = val;
            this.getList();
        },
        // 当前页改变时触发 跳转其他页
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.search.pageNum = val;
            this.getList();
        },
        resetSearch() {
            let search = {
                pageNum: this.search.pageNum,
                pageSize: this.search.pageSize,
            };
            this.search = search;
            this.getList();
        },
        editItem(row) {
            this.form = this.$deepClone(row)
            this.visible = true
        },
        async handleCommand(command) {
            this.form.status = Number(command)
            const res = await this.$request.put('/jc/shenpi/' + this.form.id + '/', this.form)
            if (res.data.code === 200) {
                this.$message.success(res.data.message)
                this.getList()
            }

        }
        ,
        er(row) {
            this.form.id = row.id
        }

    },
};
</script>
  
<style scoped>
.el-pagination {
    margin-top: 10px;
}

.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
}

.el-icon-arrow-down {
    font-size: 12px;
}

.el-row {
    margin-bottom: 20px;
}

.el-row:last-child {
    margin-bottom: 0px;
}
</style>