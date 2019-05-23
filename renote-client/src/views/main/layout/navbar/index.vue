<template>
    <v-card hright="50" color="info">
        <v-layout justify-start>
            <v-btn flat icon v-show="$store.getters.sidebar" @click="clickBtn">
                <v-icon>fa fa-caret-square-o-left</v-icon>
            </v-btn>
            <v-btn flat icon v-show="!$store.getters.sidebar" @click="clickBtn">
                <v-icon>fa fa-caret-square-o-right</v-icon>
            </v-btn>
        </v-layout>
    </v-card>
</template>

<script>
    export default {
        name: "Navbar",
        data() {
            return {

            }
        },
        methods: {
            clickBtn() {
                this.$store.commit('SET_CLOSE')
            }
        }
    }
</script>

<style scoped>

</style>