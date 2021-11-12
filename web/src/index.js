import React from 'react'
import { render } from 'react-dom'
import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'
import App from './App'
import reducer from './reducers'
import './index.css'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'

const store = createStore(
  reducer,
  composeWithDevTools(applyMiddleware(thunk))
)

render(
  <Provider store={store}>
    <App dispatch={store.dispatch}/>
  </Provider>,
  document.getElementById('root')
)