import Vuetify from "vuetify/lib";
import Vue from 'vue'

Vue.use(Vuetify, {
    theme: {
        primary: "#ee44aa",
        secondary: "#424242",
        accent: "#82B1FF",
        error: "#FF5252",
        info: "#2196F3",
        success: "#4CAF50",
        warning: "#FFC107"
    },
    customProperties: true,
    iconfont: "fa4",
    icons: {
        'move-left': 'fa fa-caret-square-o-left',
        'move-right': 'fa fa-caret-square-o-right'
    }
});