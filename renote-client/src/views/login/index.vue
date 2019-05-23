<template>
    <v-container fluid fill-height >
        <v-layout align-center justify-center >
            <v-flex xs3>
                <v-form ref="form" v-model="queryForm" lazy-validation>
                    <v-text-field v-model="queryForm.username" :counter="10" :rules="nameRules" label="Username" required></v-text-field>

                    <v-text-field v-model="queryForm.password"
                                  :type="show ? 'text' : 'password'"
                                  :rules="passRules" label="Password" required @click:append="show = !show"
                                  :append-icon="show ? 'fa fa-eye-slash' : 'fa fa fa-eye'">
                    </v-text-field>

                    <v-checkbox v-model="queryForm.agree" :error-messages="mustAgree" required>
                        <template slot="label">
                            <v-btn flat color="info" to="/">Agree us</v-btn>
                        </template>
                    </v-checkbox>

                </v-form>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
        queryForm: {
            username: '',
            password: '',
            agree: true
        },
        nameRules: [
            v => !!v || 'Name is required',
            v => (v && v.length <= 10) || 'Name must be less than 10 characters'
        ],
        passRules: [
            v => !!v || 'Password is required',
            v => (v && v.length >= 6&& v.length <= 15) || 'Password must be more than 6 characters and less than 20 characters'
        ],
        mustAgree: 'You must agree',
        show: false
    }
  },

}
</script>

<style>

</style>
