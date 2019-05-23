<template>
    <v-container fluid fill-height >
        <v-layout align-center justify-center >
            <v-flex xs3>
                <v-form ref="form" v-model="valid" lazy-validation>
                    <v-text-field v-model="queryForm.username" :counter="15" :rules="nameRules" :label="$t('user.username')" required>
                    </v-text-field>

                    <v-text-field v-model="queryForm.password" :counter="15"
                                  :type="show ? 'text' : 'password'"
                                  :rules="passRules" :label="$t('user.password')" required @click:append="show = !show"
                                  :append-icon="show ? 'fa fa-eye-slash fa-lg' : 'fa fa fa-eye fa-lg'">
                    </v-text-field>

                    <v-checkbox v-model="queryForm.agree" :rules="checkBoxRule" required>
                        <template slot="label">
                            <v-btn flat color="info" to="/">{{$t('tip.agree')}}</v-btn>
                        </template>
                    </v-checkbox>
                    <v-btn :disabled="!valid" color="info" @click="login" block>
                        {{$t('login.login')}}
                    </v-btn>
                    <v-layout justify-end row>
                        <v-btn flat color="info" to="/forget">{{$t('login.forget')}}</v-btn>
                        <v-btn flat color="info" to="/register">{{$t('login.register')}}</v-btn>
                    </v-layout>


                </v-form>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            valid: true,
            queryForm: {
                username: '',
                password: '',
                agree: true
            },
            nameRules: [
                v => !!v || this.$t('tip.usernameNotNull'),
                v => (v && v.length <= 15) || this.$t('tip.usernameNotNull')
            ],
            passRules: [
                v => !!v || this.$t('tip.passwordNotNull'),
                v => (v && v.length >= 6&& v.length <= 15) || this.$t('tip.passwordLength')
            ],
            checkBoxRule: [
                v => !!v || this.$t('tip.agree'),
            ],
            show: false
        }
    },
    methods: {
        login() {
            this.$refs.form.validate()
        }
    }
}
</script>

<style>

</style>
