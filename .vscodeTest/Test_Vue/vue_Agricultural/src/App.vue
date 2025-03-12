<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <!-- <div>{{value1}}</div>
  <div>{{pinjie}}</div>
  <button @click="func1">按钮</button> -->
  <!-- <Demo :msg="17+18" :obj="{name:'list',age:20} "></Demo> -->
  <!-- <Demo :msg="17+18" :obj="object" @demo-click="func1" @demo-init="func2"></Demo> -->
  <!-- 双引号里面17+18，也可以是对象{{}}， -->
  <router-view></router-view>
</div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
// import Demo from './components/Demo.vue'//导入import,后面加路径

export default {
  name: 'App',
    data(){
    return{
      value1:'abc',
      value2:'def',
      object:{
        name:'list',
        age:20
      }
    }
  },
  methods:{
    func1(param){
      // console.log(param);
      alert('111');
    },
    func2(val){
      console.log(val)
    }
  },

  computed:{
    pinjie(){
      return this.value1+this.value2;
    }
  },

  watch:{
    value(val,oval){

    }
  },
  components: {
    // HelloWorld,
    // Demo
  },
  mounted(){
    console.log('挂载后')
  },
  created(){
    console.log('创建完成')
  }
}
</script>

<style >
body,html{
  margin: unset;
}
</style>
