var bLogeo = document.getElementById('signin');
bLogeo.addEventListener('click', function () {
    const parametros = new URLSearchParams();
    parametros.append('Prtemail', document.getElementById('email').value);
    parametros.append('Prtpassword', document.getElementById('password').value);
    // axios.get('http://127.0.0.1:4567/hello/'+parametros)
    //     .then(function (response) {
    //         console.log(response)
    //         console.log(response.data)
    //         console.log(response.statusText)
    //         document.getElementById('titulo').innerHTML = response.data
    //     })
    //     .catch(function (error) {
    //         console.log(error)
    //     })
    axios.get('http://127.0.0.1:4567/queryparms?' + parametros)
        .then(function (response) {
            console.log(response)
            console.log(response.data)
            console.log(response.statusText)
            document.getElementById('titulo').innerHTML = response.data
        })
        .catch(function (error) {
            console.log(error)
        })

    // // llamada POST que envia un objeto JSON   application/json
    // axios.post('http://127.0.0.1:4567/json', {
    //     PrtEmail : document.getElementById('email').value,
    //     PrtPassword : document.getElementById('password').value
    // })
    //     .then(function (response) {
    //         console.log(response)
    //         console.log(response.data)
    //         console.log(response.statusText)
    //         document.getElementById('titulo').innerHTML = response.data
    //     })
    //     .catch(function (error) {
    //         console.log(error)
    //     })
    // llamada POST que envia un objeto ???  application/x-www-form-urlencoded
    // axios.post('http://127.0.0.1:4567/formdata', parametros)
    //     .then(function (response) {
    //         console.log(response)
    //         console.log(response.data)
    //         console.log(response.statusText)
    //         document.getElementById('titulo').innerHTML = response.data
    //     })
    //     .catch(function (error) {
    //         console.log(error)
    //     })
})