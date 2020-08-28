<template>
    <div class="app-container">
        <ul class="mui-table-view mui-table-view-chevron" style="margin-bottom: 53px">
            <li class="mui-table-view-cell mui-media" v-for="item in data.data">
                <router-link class="mui-navigate-right" :to="'/orderDetail?orderId='+item.orderId"  >
                    <div class="mui-row">
                        <div class="mui-media-body mui-col-xs-9" style="margin: 0;padding: 0">
                            <span style="float: left">订单号：{{item.orderId}}</span>
                            <span style="float: right">￥<span class="price">{{item.orderAmount}}</span></span>
                        </div>
                        <div class="mui-media-body mui-col-xs-9" style="margin-top: 10px">
                            <span style="float: left;color: #c8cbcf;font-size: 12px;">{{dateFormat(item.createTime)}}</span>
                            <span class="orderStatus">{{transformOrderStatus(item.orderStatus)}}</span>
                        </div>
                    </div>
                </router-link>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "Order",
        data(){
            return {
                data: {
                    "code": 0,
                    "msg": "成功",
                    "data": null
                },
                active: 'tab-container1'
            }
        },
        created(){
            this.$store.state.index = 2;
            const _this = this
            axios.get('http://localhost:8020/order-service/buyer/order/list/'+JSON.parse(window.localStorage.getItem('access-user')).openid+'/1/100').then(function (resp) {
                _this.data = resp.data
            })

        },
        methods:{
            transformOrderStatus(status){
                switch (status){
                    case 0: return '新订单';break;
                    case 1: return '已完成';break;
                    case 2: return '已取消';break;
                }
            },
            dateFormat(time) {
                var date = new Date();
                date.getDate(time);
                var year=date.getFullYear();
                var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
                var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
                var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
                var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
                var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
                return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
            }
        }
    }
</script>

<style scoped>
    .app-container{

    }
    .mui-media-body{
        font-size: 14px;
    }
    .mui-ellipsis{
        font-size: 12px;
    }
    .price{
        color: red;
        font-size: 18px;
        font-weight: bold;
    }
    a:after,a:link,a:active,a:visited{
        text-decoration:none;
    }
    .orderTime{
        color: #c8cbcf;
        font-size: 12px;
    }
    .head-img{
        width: 60px;
        height: 58px;
    }
    .orderStatus{
        display: inline-block;
        float: right;
        color: cornflowerblue;
    }
</style>
