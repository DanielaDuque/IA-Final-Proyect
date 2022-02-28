class GameControler {
    constructor(){
        this.game = new Array(9);
        this.win = "C";
        for (let row = 0; row < 9; row++) {
            this.game[row] = []; 
            for (let col = 0; col < 9; col++) {
                this.game[row].push("C");
            } 
        }
    }

    async makeMove(row, col){
    
        this.game[row][col] = "B";
        console.log("entre");
        await this.isWining ("B", row,col);
        
    }

    async makeMoveBack(typ, row, col){

        const data = {  tablero: this.game,
                        position : { row : row,
                                    col : col},
                        type : typ  };
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
                this.game = data;
                })
                .catch((error) => {
                console.error('Error:', error);
                });
        await this.isWining ("W", row,col);
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