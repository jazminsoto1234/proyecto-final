import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    pedidos: []
}

export const pedidoSlice = createSlice({
    name: 'pedido',
    initialState,
    reducers: {
        addPedido: (state, action) => {
            return { pedidos: [...state.pedidos, action.payload]}
        },
        clearPedidos: (state) => {
            return { pedidos: []}
        }
    }
})

export const pedidos = state => state.pedido.pedidos

export const { addPedido, clearPedidos } = pedidoSlice.actions

export default pedidoSlice.reducer

