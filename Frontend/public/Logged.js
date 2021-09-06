import { Sentence } from './classes/Sentence.js';
import { User } from './classes/User.js';
const form = document.querySelector('form');
const htmlSentence = document.querySelector('#english-sentence');
const htmlTranslation = document.querySelector('#german-sentence');
const input = document.querySelector('#awnser');
const username = document.querySelector('#username');
const points = document.querySelector('#points');
let user = new User();
user = JSON.parse(localStorage.getItem('user'));
if (user === null) {
    window.location.replace('./login.html');
}
points.textContent = user.amountPoints + ' points';
username.textContent = user.username;
let sentence = new Sentence();
setUp();
// localStorage.clear()
form.addEventListener('submit', (e) => {
    e.preventDefault();
    if (input.value === sentence.deletedWord) {
        input.value = '';
        input.style.borderColor = '';
        document.querySelector('#error-log').textContent = '';
        fetch('http://localhost:8081/api/users/' + user.id + '/addPoint');
        user.amountPoints = user.amountPoints + 1;
        points.textContent = user.amountPoints + ' points';
        setUp();
    }
    else {
        document.querySelector('#error-log').textContent = 'Your awnser is wrong';
        input.style.borderColor = 'red';
    }
});
function setUp() {
    getRandomSentence();
    let temp = JSON.parse(localStorage.getItem('sentence'));
    sentence.id = temp.id;
    sentence.sentence = temp.sentence;
    sentence.translation = temp.translation;
    sentence.deleteRandomWord();
    htmlSentence.textContent = sentence.sentence;
    htmlTranslation.textContent = sentence.translation;
}
function getRandomSentence() {
    fetch('http://localhost:8081/api/sentences/random')
        .then(r => r.json())
        .then(r => localStorage.setItem('sentence', JSON.stringify(Object.assign(new Sentence(), r))));
}
