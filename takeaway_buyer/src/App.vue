<template>
  <div id="app">
    <mt-header title="外卖订餐系统">
      <mt-button  icon="back" slot="left" @click="back">返回</mt-button>
    </mt-header>
    <router-view/>
    <nav class="mui-bar mui-bar-tab" id="bar-tab">
      <div class="mui-tab-item" @click="$store.state.index=1,$router.push('/')">
        <span class="mui-icon mui-icon-compose" :class="{'mui-active':$store.state.index==1}"></span>
        <span class="mui-tab-label" :class="{'mui-text-active':$store.state.index==1}">点餐</span>
      </div>
      <div class="mui-tab-item"  @click="$store.state.index=2,$router.push('/order')">
        <span class="mui-icon mui-icon-bars" :class="{'mui-active':$store.state.index==2}"></span>
        <span class="mui-tab-label" :class="{'mui-text-active':$store.state.index==2}">订单</span>
      </div>
      <div class="mui-tab-item" @click="$store.state.index=3,$router.push('/mine')">
        <span class="mui-icon mui-icon-person" :class="{'mui-active':$store.state.index==3}"><span class="mui-badge">1</span></span>
        <span class="mui-tab-label" :class="{'mui-text-active':$store.state.index==3}">我的</span>
      </div>
    </nav>
  </div>
</template>

<script>
  export default {
    methods:{
      test:function () {
          this.$toast('Hello WOrd');
      },

      test1:function () {
        axios.get('http://localhost:7366/index').then(function (response) {
            console.log(response)
        })
      },
      back() {
        history.go(-1)
      }

    }


  }
</script>

<style>

  .mui-text-active
  {
    color: rgb(64,130,252);
  }

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
