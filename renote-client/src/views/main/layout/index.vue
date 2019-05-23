<template>
    <v-container fluid class="container" >
        <v-layout row >
            <v-flex align-start >
                <v-flex >
                    <sidebar :style="height.sidebar" />
                </v-flex>
            </v-flex>
            <v-flex md12 shrink>
                <v-layout md12 fill-height column>
                    <v-flex md12>
                        <navbar :style="height.navbar"/>
                    </v-flex>
                    <v-flex md12>
                        <container :style="height.container"/>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>

    </v-container>
</template>

<script>
    import Container from "@/views/main/layout/container/index";
    import Sidebar from "@/views/main/layout/sidebar/index";
    import Navbar from "@/views/main/layout/navbar/index";
    export default {
        name: "Layout",
        components: {Navbar, Sidebar, Container},
        data() {
            return {
                height: {
                    sidebar: 'height:'+document.body.clientHeight+'px',
                    navbar: 'height: 50px',
                    container: 'height:'+(document.body.clientHeight-50)+'px'
                }
            }
        }
    }
</script>

<style scoped>
    .container{
        padding: 0px;
    }
</style>