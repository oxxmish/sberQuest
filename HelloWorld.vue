<template>
<div class="Main">
  <div class="Label_text2">
      СберКвест
  </div>
  <div class="hello" >
    <div class="Label_text3">
      Вход
    </div>
    <div class="tabs">
      <input type="radio" name="tab-btn" id="tab-btn-1" value="" checked >
      <label for="tab-btn-1" >Войти по логину</label>
      <input type="radio" name="tab-btn" id="tab-btn-2" value="" >
      <label for="tab-btn-2" >Войти по номеру комнаты</label>
      <div id="content-1" >
        <form class="sign-up" >
            <div class="form-group3">
              <input class="form-group" v-model="message" placeholder="Логин/E-mail">
              <input class="form-group" v-model="message" placeholder="Пароль">
            </div>
            <button class="button">Войти</button>
        </form>
        <div class="text-url">
          <a href="#" class="txt2 hov1">
             Забыли пароль?
            </a>
        </div>
        <div class="text-url">
          <span class="txt1">
            Создать аккаунт?
          </span>
          <a href="#" class="txt2 hov1">
            Зарегистрируйтесь
            </a>
        </div>
      </div>
      <div id="content-2">
        <form class="sign-up" >
          <div class="form-group3">
            <input class="form-group" v-model="message" placeholder="Номер комнаты">
            <input class="form-group" v-model="message" placeholder="Имя">
          </div>
          <button class="button">Войти</button>
        </form>
      </div>
    </div>
  </div>
</div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .tabs {
    font-size: 0;
  }

  .tabs>input[type="radio"] {
    display: none;
  }

  .tabs>div {
    /* скрыть контент по умолчанию */
    display: none;
    padding: 10px 15px;
    font-size: 16px;
  }

  /* отобразить контент, связанный с вабранной радиокнопкой (input type="radio") */
  #tab-btn-1:checked~#content-1,
  #tab-btn-2:checked~#content-2 {
    display: block;
  }

  .tabs>label {
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    user-select: none;
    padding: 5px 10px;
    font-size: 18px;
    color: #f0f0f0;
    line-height: 1.5;
    transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out;
    cursor: pointer;
    position: relative;
    top: 1px;
  }

  .tabs>label:not(:first-of-type) {
    border-left: none;
  }
  /* Внешний вид вкладки активной*/
  .tabs>input[type="radio"]:checked+label {
    text-decoration: underline;
  }

  .Label_text2  {
color: #3db33d;
margin-left: auto;
margin-right: auto;
font-size: 80px;
margin-top: 20px;
margin-bottom: 40px;
}
  .Label_text3  {
color: #f9fff9;
font-size: 40px;
margin-bottom: 10px;
}
.hello  {
  width: 450px;
    height: 420px;
    background: #21A038;
     margin-left: auto;
    margin-right: auto;
    border-radius: 15px;
    margin-top: 50px;
}

.form-group  {
  width: 320px;
  height: 30px;
  border-radius: 25px;
  margin-top: 20px;
  font-size: 20px;
}
.button  {
  width: 170px;
    height: 50px;
    background: #007A10;
     margin-left: auto;
    margin-right: auto;
    border-radius: 25px;
    margin-top: 35px;
  color: #ffffff;
  font-size: 20px;
}
.text-url  {
  margin-top: 20px;
  font-size: 20px;
  color: #f0f0f0;
}
.txt2 hov1{
  color: #f0f0f0;
}
</style>
