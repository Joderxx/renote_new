import Vue from 'vue'
import Router from 'vue-router'
import {constantRoutesData,asyncRoutesData} from './route-data'
import {deepClone} from "@/utils";

Vue.use(Router)


export const constantRoutes = process.env.VUE_APP_LOCAL?
    deepClone([...constantRoutesData,...asyncRoutesData]):
    deepClone([...constantRoutesData])

export default new Router({
  mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

export const asyncRoutes = deepClone([...asyncRoutesData])
