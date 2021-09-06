import { User } from "./classes/User.js"

const form = document.querySelector('form') as HTMLFormElement

// inputs
const username = document.querySelector('#username') as HTMLSelectElement
const password = document.querySelector('#password') as HTMLSelectElement

form.addEventListener('submit', (e: Event) => {
    e.preventDefault()
    let link = 'http://localhost:8081/api/users/login'
    let method = 'post'

    if (window.location.href.split('/')[window.location.href.split('/').length-1] === 'signup.html') {
        link = 'http://localhost:8081/api/users'
        method = 'put'
    }
    fetch(link, {
        method: method,
        mode: "cors",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username.value,
            password: password.value
        })
    })
        .then(r => r.json())
        .then(r => initializeAndSaveUser(r))
})

function initializeAndSaveUser(r: any): void {
    if (typeof r.id === 'undefined') {
        password.style.borderColor = 'red'
        username.style.borderColor = 'red'
        if (r.message === 'This username is already taken') {
            document.querySelector('#error-log')!.textContent = 'Username is already taken'
        } else if (r.message === 'The login did not work') {
            document.querySelector('#error-log')!.textContent = 'This user does not exist'
        } else {
            document.querySelector('#error-log')!.textContent = 'Something went wrong...'
        }
    } else {
        password.style.borderColor = 'grey'
        username.style.borderColor = 'grey'
        document.querySelector('#error-log')!.textContent = ''
        localStorage.setItem('user', JSON.stringify(Object.assign(new User(), r)))
        window.location.replace('./main.html')
    }
}