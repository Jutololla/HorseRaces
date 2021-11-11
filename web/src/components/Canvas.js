import React from 'react'
import useCanvas from './useCanvas'

const Canvas = props => {  
  
  const { draw, ...rest } = props
  const canvasRef = useCanvas(draw)
  
  return <canvas width="800" height="100" ref={canvasRef} {...rest}/>
}

export default Canvas