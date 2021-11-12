import React from 'react'
import useCanvas from './useCanvas'

const Canvas = props => {  
  
    const { draw,velocidad, ...rest } = props
    const canvasRef = useCanvas(draw,velocidad)
    
    return <canvas width="785" height="100" ref={canvasRef} {...rest}/>
}

export default Canvas