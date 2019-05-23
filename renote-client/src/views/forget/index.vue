<template>
    <v-container fluid fill-height >
        <v-layout align-center justify-center >
            <v-flex xs3>
                <v-form ref="form" v-model="valid" lazy-validation>
                    <v-text-field v-model="queryForm.email"
                                  type="email"
                                  :rules="emailRules" :label="$t('user.email')"
                                  required>
                        <template slot="append" v-if="show.send">
                            <v-btn flat color="info" disabled>{{$t('common.have')}}{{sec}}{{$t('common.second')}}</v-btn>
                        </template>
                        <template slot="append" v-else>
                            <v-btn flat color="info" @click="sendCode">{{$t('common.sendCode')}}</v-btn>
                        </template>
                    </v-text-field>

                    <v-text-field v-model="queryForm.code" @blur="validateCode"
                                  :rules="codeRules" :label="$t('common.validateCode')" required
                                  :append-icon="show.valid ? 'fa fa-check fa-lg' : 'fa fa fa-times fa-lg'">
                    </v-text-field>
                    <v-text-field v-model="queryForm.password" :counter="15"
                                  :type="show ? 'text' : 'password'"
                                  :rules="passRules" :label="$t('user.password')" required @click:append="show.pass = !show.pass"
                                  :append-icon="show.pass ? 'fa fa-eye-slash fa-lg' : 'fa fa fa-eye fa-lg'">
                    </v-text-field>
                    <v-text-field v-model="queryForm.repeatedPassword" :counter="15"
                                  :type="show ? 'text' : 'password'"
                                  :rules="rePassRules" :label="$t('user.repeatedPassword')" required @click:append="show.rePass = !show.rePass"
                                  :append-icon="show.rePass ? 'fa fa-eye-slash fa-lg' : 'fa fa fa-eye fa-lg'">
                    </v-text-field>
                    <v-btn :disabled="!valid" color="info" @click="forget" block>
                        {{$t('forget.query')}}
                    </v-btn>
                    <v-layout justify-start row>
                        <v-btn flat color="info" to="/login">{{$t('forget.login')}}</v-btn>
                    </v-layout>
                </v-form>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import {validEmail} from "@/utils/validate";

    export default {
    data() {
        return {
            valid: true,
            queryForm: {
                email: '',
                code: '',
                password: '',
                repeatedPassword: ''
            },
            emailRules: [
                v => !!v || this.$t('tip.email'),
                v => v&& validEmail(v) || this.$t('tip.emailError')
            ],
            codeRules: [
                v => !!v || this.$t('tip.code')
            ],
            passRules: [
                v => !!v || this.$t('tip.passwordNotNull'),
                v => (v && v.length >= 6 && v.length <= 15) || this.$t('tip.passwordLength')
            ],
            rePassRules: [
                v => !!v || this.$t('tip.passwordNotNull'),
                v => (v && v.length >= 6 && v.length <= 15) || this.$t('tip.passwordLength'),
                v => v===this.queryForm.password || this.$t('tip.repeatedPassword'),
            ],
            sec: 0,
            timer: null,
            show: {
                send: false,
                pass: false,
                rePass: false,
                valid: true
            }
        }
    },
    methods: {
        forget() {
            this.$refs.form.validate()
        },
        sendCode() {
            if (validEmail(this.queryForm.email)){
                clearInterval(this.timer)
                this.sec = 60
                this.timer = setInterval(()=>{
                    if (this.sec>0){
                        this.sec -=1
                    }else{
                        this.show = false
                        clearInterval(this.timer)
                    }
                },1000)
                this.show.send=true
            }
        },
        validateCode(){

        }
    }
}
</script>

<style>

</style>
