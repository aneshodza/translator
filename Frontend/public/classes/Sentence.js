export class Sentence {
    constructor() {
        this.id = 0;
        this.sentence = '';
        this.translation = '';
        this.deletedWord = '';
    }
    deleteRandomWord() {
        let temp = this.translation.split(" ");
        let index = Math.floor(Math.random() * temp.length);
        this.deletedWord = temp[index];
        this.translation = '';
        for (let i = 0; i < temp.length; i++) {
            if (i === index) {
                this.translation = this.translation + ' ___';
            }
            else {
                this.translation = this.translation + ' ' + temp[i];
            }
        }
    }
}
