<template>
    <div class="mui-page-content">
        <div>
            <ul class="mui-table-view" >
                <li class="mui-table-view-cell">
                    <span class="mui-icon mui-icon-contact"></span><p class='mui-ellipsis'>{{buyer.name}}</p>
                </li>
            </ul>
            <br/>

            <ul class="mui-table-view" >
                <li class="mui-table-view-cell">
                    <router-link to="order" class="mui-navigate-right" >我的订单</router-link>
                </li>
                <li class="mui-table-view-cell">
                    <router-link to="about" class="mui-navigate-right" >关于点餐平台</router-link>
                </li>
            </ul>
            <br/><br/><br/>
            <button class="mui-btn mui-btn-danger mui-btn-block quit" @click="logout">退出登录</button>
        </div>
    </div>

</template>

<script>
    import { MessageBox } from 'mint-ui';
    export default {
        name: "Mine",
        data(){
            return {
                buyer:null
            }
        },
        methods:{
            logout(){
                MessageBox.confirm('确定退出吗?').then(action => {
                    localStorage.removeItem('access-user')
                    this.$router.replace({path: '/'})
                })
            }
        },
        created() {
            this.$store.state.index = 3
            this.buyer = JSON.parse(window.localStorage.getItem('access-user'))
        }
    }
</script>

<style scoped>
    .mui-page-content{
        background-color: #efeff4;
    }
    .quit{
        margin: 0 auto;
        width: 95%;

    }

    a:after,a:link,a:active,a:visited{
        text-decoration:none;
    }
</style>
