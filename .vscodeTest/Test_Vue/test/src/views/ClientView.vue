<template >
    <div id="client-view">
        <my-header></my-header>
        <router-view></router-view>
        <my-footer></my-footer>
    </div>
</template>
<script>
import MyHeader from '@/components/MyHeader.vue';
import MyFooter from '@/components/MyFooter.vue';

export default {
  components: { MyHeader,MyFooter },
    name:'ClientView',
    mounted(){
        if(this.$route.fullPath=='/'||this.$route.fullPath==''){
            this.$router.push('/home')
            //生命周期
        }
    }
}
</script>
<style scoped> 

</style>