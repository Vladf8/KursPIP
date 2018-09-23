 $(function(){
            var output = $('#resp-status-text'); // блок вывода информации
            $('#SingUp').click( function(){
                
                var name = document.getElementById("Username1").value;
                var email = document.getElementById("Email1").value;
                var password = document.getElementById("Password1").value;

                $.ajax({
                    type: 'POST', // метод передачи данных
                    url: '/auth/singup', // путь
                    //dataType: 'text', // тип ожидаемых данных в ответе

                    data: JSON.stringify({name: name, email: email, password: password}), // данные, которые передаем на сервер
                    beforeSend: function () { // Функция вызывается перед отправкой запроса

                        output.text('...Wait...');
                    },
                    error: function (req, text, error) { // отслеживание ошибок во время выполнения ajax-запроса
                        output.text('Error: ' + text + ' | ' + error);
                    },

                    success: function (data) { // функция, которая будет вызвана в случае удачного завершения запроса к серверу
                        alert(data);
                        output.text(data); // выводим на страницу данные, полученные с сервера
                    },
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
            })
       })