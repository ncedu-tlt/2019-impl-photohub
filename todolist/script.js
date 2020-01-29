Vue.component('todo-item', {
  template: '\
    <li>\
      {{ title }}\
      <button v-on:click="$emit(\'remove\')">Удалить</button>\
    </li>\
  ',
  props: ['title']
})

new Vue({
  el: '#todo-list',
  data: {
    newTodoText: '',
    todos: [
      {
        id: 1,
        title: 'Невыполнимая задача'
      }
    ],
    nextTodoId: 2
  },
  methods: {
    addNewTodo: function () {
      this.todos.push({
        id: this.nextTodoId++,
        title: this.newTodoText
      })
      this.newTodoText = ''
    }
  }
})