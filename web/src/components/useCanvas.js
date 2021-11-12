import { useRef, useEffect } from 'react'

const useCanvas = (draw,velocidad) => {
    //console.log("velocidad")
    //console.log(velocidad)
  const canvasRef = useRef(null)
  
  useEffect(() => {
    
    const canvas = canvasRef.current
    const context = canvas.getContext('2d')
    let frameCount = 0
    let animationFrameId
    let currentLoopIndex = 0;
    let isrun=true;
    
    const cycleLoop = [0, 1,0, 2];
    const render = () => {
      
        frameCount++
        animationFrameId = window.requestAnimationFrame(render)
      

        if(frameCount>15 && velocidad<=800){
          if(velocidad<=650){
          draw(context, frameCount,currentLoopIndex,velocidad)
          currentLoopIndex++
          velocidad+=velocidad
        }
        else{
          velocidad=650
          draw(context, frameCount,currentLoopIndex,650)
        }
        
        
        console.log(velocidad)

        
       
        if (currentLoopIndex >= cycleLoop.length) {
            currentLoopIndex = 0;
        }
       animationFrameId = window.requestAnimationFrame(render)
       frameCount=0
      
    }
        
    }
    render()
    
    return () => {
      window.cancelAnimationFrame(animationFrameId)
    }
  }, [draw])
  
  return canvasRef
}
export default useCanvas