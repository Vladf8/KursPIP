 $(function(){
            $('#SingUp').click( function(){
                
                var name = document.getElementById("Username1").value;
                var email = document.getElementById("Email1").value;
                var password = document.getElementById("Password1").value;

                $.ajax({
                    type: 'POST', // метод передачи данных
                    url: 'http://localhost:3250/api/auth/signup', // путь
//                    ContentType: 'application/json',
                    dataType: 'json', // тип ожидаемых данных в ответе
                    crossFomain:true,

                    data: JSON.stringify({email: email, password: password}), // данные, которые передаем на сервер
                    beforeSend: function () { // Функция вызывается перед отправкой запроса
                        alert(name + email + password)
                        
                        
                    },
                    error: function (req, text, error) {
                        alert("ne ok");
                        alert(req.responseText +' | ' + text + ' | ' + error);// отслеживание ошибок во время выполнения ajax-запроса
                    },

                    success: function (data) {
                        alert("Ok");// функция, которая будет вызвана в случае удачного завершения запроса к серверу
                        alert(data);
                    },
                    headers: {
                        "ContentType":"application/json"
                        
                    },
                    complete: function(req,status){
                        alert("Complete");
                    }
                })
            })
       })