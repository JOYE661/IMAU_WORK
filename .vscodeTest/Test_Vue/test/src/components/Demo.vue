<template>
    <div id="demo">
        {{msg}}
        {{obj.name}},{{obj.age}}
        <button @click="handleCliak">按钮</button>
    </div>
</template>

<script>
export default{
    name:'Demo',
    comments:{},
    props:{//主键的属性
    // 主键初始化
        msg:{

            type:String,
            default:'hello'
        },
        // 对象类型
        obj:{
            type:Object,
            default:()=>{
                return {name:'zhangsan',age:19}
            }
        }
    },
    data(){
        return{

        }
    },
    methods:{
        handleClick(){
            console.log('子组件：按钮点击')
            this.$emit('demo-click','按钮点击')
        }
    },
    mounted(){
        this.$emit('demo-init','demo组件初始化')
    }
}

</script>

<style scoped>
/* 防止样式混乱 */

</style>
