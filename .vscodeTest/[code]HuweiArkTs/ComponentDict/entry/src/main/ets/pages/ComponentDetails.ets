import { MyText } from '../common/components/MyText';
import router from '@ohos.router';
import { MyTextInput } from '../common/components/MyTextInput';
@Entry
@Component
struct ComponentDetails {
  @State compnentName: string = router.getParams()['name']

  build() {

      Column() {
        if(this.compnentName=='Text'){
          MyText()
        }
        if(this.compnentName == 'TextInput'){
          MyTextInput()
        }

      }
  }
}