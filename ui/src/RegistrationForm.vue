<template>
<div class="container-login100">
    <div class="wrap-login100 col-sm-3 mx-auto">             
            <div class="login100-form-title">
                <div class="green_part">Э</div><div class="black_part">ко</div><div class="green_part">К</div><div class="black_part">вест</div>
            </div>

            <div class="login100-">
                <div class="form-group">
                    <label class="form-label" for="name">ФИО</label>
                    <input type="text" class="form-control" id="name" placeholder="Введите имя">

                </div>

                <div class="form-group">
                    <label class="form-label" for="login">Логин</label>
                    <input type="text" class="form-control" id="login" placeholder="Введите логин">

                </div>

                <div class="form-group">
                    <label class="form-label" for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" placeholder="Введите пароль">
                </div>

                <div class="form-group">
                    <label class="form-label" for="repeatPassword">Повторите пароль</label>
                    <input type="password" class="form-control" id="repeatPassword" placeholder="Введите пароль">
                </div>

                <div class="login_button">Зарегистрироваться</div>

                <div @click="already_registered" class="alreadyLogin_button">У меня уже есть аккаунт</div>
            </div>                             
    </div>      
</div>
</template>

<script>
export default {
  name: 'RegistrationForm',
  methods:
  {
    already_registered: function()
    {
        this.$emit('already-registered');
    }
  }
    
}
</script>

<style scoped>
.login100-form {
    width: 100%;
}
.login100-form-title {
    display: block;
    font-size: 4.5vw;
    color: #333333;
    text-align: center;
    margin-bottom: 10%;
    
    display: flex;
  align-items: center;
  justify-content: center;
}

.green_part{
    float: left;
    color: rgb(33, 160, 56);
}
.black_part{
    float: left;
    color: #000000;
}

.login_button {
    margin-top: 10%;
    margin-left: 15%;
    width: 70%;
    text-align: center;
    display: block;
    background: rgb(33, 160, 56);
    border: 0;
    color: white;
    border-radius: 20px;
    outline: 1px solid groove;
    padding-top: 3.2%;
    padding-bottom: 3.2%;
    padding-left: 0.2%;
    padding-right: 0.2%;
    font-size: 1vw;
}

.login_button:hover {
    box-shadow: 0 0 10px 100px orange inset;
}

.alreadyLogin_button {
    margin-top: 3%;
    margin-left: 15%;
    width: 70%;
    text-align: center;
    display: block;
    background: white;
    border: 1px solid rgb(33, 160, 56);
    color: rgb(33, 160, 56);
    border-radius: 20px;
    padding-top: 3%;
    padding-bottom: 3%;
    font-size: 1vw;
}

.alreadyLogin_button:hover {
    box-shadow: 0 0 10px 100px rgba(255, 165, 0, 0.5) inset;
    /* color: white; */
}

.wrap-login100 {
    width: 25%;
    height: 75%;
    background: #fff;
    border-radius: 10px;
    overflow: hidden;
    padding: 4% 4% 4% 4%;
    box-shadow: 0 5px 10px 0px rgba(0, 0, 0, 0.1);
    -moz-box-shadow: 0 5px 10px 0px rgba(0, 0, 0, 0.1);
    -webkit-box-shadow: 0 5px 10px 0px rgba(0, 0, 0, 0.1);
    -o-box-shadow: 0 5px 10px 0px rgba(0, 0, 0, 0.1);
    -ms-box-shadow: 0 5px 10px 0px rgba(0, 0, 0, 0.1);
}
.container-login100 {
    width: 100%;
    height: 100%;
    display: -webkit-box;
    display: -webkit-flex;
    display: -moz-box;
    display: -ms-flexbox;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    padding: 15px;
    background: #f2f2f2;
}
.form-control{
    width: 90%;
    margin-left: 5%;
    font-size: 1.4vw;
    border-bottom: 1.5px solid silver;
    border-top: none;
    border-left: none;
    border-right: none;
    outline:none;
    margin-top: 0.5%;
}
.form-label{
    margin-left: 5%;
    font-size: 1.4vw;
}
.form-group{
    margin-top: 7%;
}
</style>