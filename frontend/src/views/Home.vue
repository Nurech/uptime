<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <br>
    <button @click='getTime'>Get Time</button>


  </div>
</template>

<script>

import axios, {post} from "axios";

export default {
  name: 'Home',

  data() {
    return {
      articleId: null,
      errorMessage: null
    };
  },
}



function created() {
  // POST request using axios with error handling
  const article = { title: "Vue POST Request Example" };
  axios.post("/api/getTime", article)
      .then(response => this.articleId = response.data.id)
      .catch(error => {
        this.errorMessage = error.message;
        console.error("There was an error!", error);
      });
}

function getRandom(length) {
  let random = '0123456789';
  let result = "";
  for (let i = 0; i < length; i++) {
    result += random.charAt(Math.floor(Math.random() * random.length));
  }
  return result;
}

let i = 0;
function getOne(number) {
  let result = i + number;
  i++;
  return result;
}


</script>
