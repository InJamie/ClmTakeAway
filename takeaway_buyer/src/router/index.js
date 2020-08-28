import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Cart from "../views/Cart";
import Order from "../views/Order";
import OrderDetail from "../views/OrderDetail";
import Pay from "../views/Pay";
import Login from "../views/Login";
import Mine from "../views/Mine";
import About from "../views/About";
import Info from "../views/Info";

Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      name: '购物车',
      component: Cart
    },
    {
      path: '/order',
      name: '订单',
      component: Order
    },
    {
      path: '/orderDetail',
      name: '订单详情',
      component: OrderDetail
    },
    {
      path: '/pay',
      name: '支付',
      component: Pay
    },
    {
      path: '/login',
      name: '登录',
      component: Login
    },
    {
      path: '/mine',
      name: '我的',
      component: Mine
    },
    {
      path: '/about',
      name: '相关',
      component: About
    },
    {
      path: '/info',
      name: '填写订单相关信息',
      component: Info
    },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
  if (to.path.startsWith('/login')) {
    next()
  } else {
    let user = JSON.parse(window.localStorage.getItem('access-user'))
    if (!user) {
      next({path: '/login'})
    } else {
      next()
    }
  }
})
export default router
