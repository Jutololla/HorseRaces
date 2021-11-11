import Canvas from "../components/Canvas"




const Start=()=>{
    let img=new Image();
    img.src='https://opengameart.org/sites/default/files/horse-preview.png'
    
    const cycleLoop = [0, 1,0, 2];
    
    const draw = (ctx, frameCount,currentLoopIndex,velocidad) => {
        const scale = 1;
        const width = 120;
        const height = 128;
        const scaledWidth = scale * width;
        const scaledHeight = scale * height;
        let img=new Image();
        img.src='https://opengameart.org/sites/default/files/horse-preview.png'
        let v=0
        ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height)
        drawFrame(cycleLoop[currentLoopIndex], 0,velocidad, 0);
        v=v+velocidad;
        //console.log(frameCount)
        //ctx.fillStyle = '#000000'
        //ctx.beginPath()
        //ctx.arc(50, 100, 20*Math.sin(frameCount*0.05)**2, 0, 2*Math.PI)
        //ctx.fill()
        

        
        //drawFrame(0, 0, 0, 0);
        //drawFrame(1, 0, scaledWidth, 0);
        //drawFrame(0, 0, scaledWidth * 2, 0);

        function drawFrame(frameX, frameY, canvasX, canvasY) {
            ctx.drawImage(img,frameX * width, frameY * height, width, height,
                canvasX, canvasY, scaledWidth, scaledHeight);
            }
    }
        return <section>

       <Canvas draw={draw} velocidad={20}/>
       <Canvas draw={draw} velocidad={40}/>
       <Canvas draw={draw} velocidad={100}/>

       </section>
}
export default Start