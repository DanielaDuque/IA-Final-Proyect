class GameControler {
    constructor(size){
        this.size = size
        this.empty = 0;
        this.black = 2;
        this.white = 1;
        this.game = new Array(this.size);
        this.win = 0;
        this.position = {row:0,
                        col :0}
        for (let row = 0; row < this.size; row++) {
            this.game[row] = []; 
            for (let col = 0; col < this.size; col++) {
                this.game[row].push(this.empty);
            } 
        }
    }

    makeMove(row, col){
        this.game[row][col] = this.black;
        console.log("entre");
    }

    async makeMoveBack(typ, row, col){

        const data = {  tablero: this.game,
                        position : { row : row,
                                    col : col},
                        type : typ  };
                        console.log(JSON.stringify(data))
        await fetch('http://localhost:4000/changePostions', {
                method: 'POST', // or 'PUT'
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
                })
                .then(response => response.json())
                .then(data => {
                //console.log('Success:', data);
                this.game = data.tablero;
                this.position = data.position;
                   
                })
                .catch((error) => {
                console.error('Error:', error);
                });
            await this.isWining (this.white, this.position.row,this.position.col);  
    }

    async isWining(typ, row, col){

        const data = {  tablero: this.game,
                        position : { row : row,
                                    col : col},
                        type : typ  };
        await fetch('http://localhost:4000/isWining', {
                method: 'POST', // or 'PUT'
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
                })
                .then(response => response.json())
                .then(data => {
                if (data) this.win = typ;
                })
                .catch((error) => {
                console.error('Error:', error);
                }); 
    }

}export default GameControler