import Canvas from "../components/Canvas"




const Start=()=>{
    let img=new Image();
    img.src='https://opengameart.org/sites/default/files/horse-preview.png'
    
    const draw = (ctx, frameCount) => {
        //ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height)
        //ctx.fillStyle = '#000000'
        //ctx.beginPath()
        //ctx.arc(50, 100, 20*Math.sin(frameCount*0.05)**2, 0, 2*Math.PI)
        //ctx.fill()
        ctx.drawImage(img,0,0,120,128,0,0,120,128)
      }
      
      return <Canvas draw={draw} />
}
export default Start