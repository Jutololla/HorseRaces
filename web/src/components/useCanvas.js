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
    
    const cycleLoop = [0, 1,0, 2];
    const render = () => {
        frameCount++
        animationFrameId = window.requestAnimationFrame(render)
      

        if(frameCount>15){
          
        //frameCount=0
        draw(context, frameCount,currentLoopIndex,velocidad)
        currentLoopIndex++
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