
const app = {
  state: {
    sidebar: false,
  },
  mutations: {
    SET_CLOSE:(state) => {
      state.sidebar = !state.sidebar
    }

  }
}

export default app
