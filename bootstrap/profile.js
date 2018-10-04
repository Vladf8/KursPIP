 $(function(){
            var output = $('#resp-status-text'); // блок вывода информации
            $(document).ready( function(){

                  var name= document.getElementById("Name").value
                  var Birhtday= document.getElementById("Birht").value
                  var Height= document.getElementById("Height").value
                  var Weight= document.getElementById("Weight").value
                  var Clan= document.getElementById("Clan").value

                $.ajax({
                    type: 'GET', // метод передачи данных
                    url: '/profile', // путь
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