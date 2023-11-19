import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";

// Estado inicial del store para las galletas
const initialState = {
    galletas: [],
    error: null,
    status: 'idle',
}

// Define un slice del store llamado 'galletas'
export const galletasSlice = createSlice({
    name: 'galletas',
    initialState,
    reducers: {},  // No hay acciones sincrónicas definidas en este slice
    extraReducers: (builder) => {
        // Agrega casos extra para manejar acciones asíncronas generadas por createAsyncThunk
        builder.addCase(fetchGalletas.fulfilled, (state, action) => {
            state.status = 'fulfilled';
            state.galletas = [...action.payload.data];
        });
        builder.addCase(fetchGalletas.pending, (state, action) => {
            state.status = 'pending';
        });
    }
})

// Exporta la acción 'getGalletas' del slice para su uso en otros lugares
export const { getGalletas } = galletasSlice.actions

// Exporta el reducer del slice para ser utilizado en la configuración del store global
export default galletasSlice.reducer

// Define una acción asíncrona utilizando createAsyncThunk para obtener galletas desde la API
export const fetchGalletas = createAsyncThunk('galletas/fetchGalletas', async () => {
    const response = await fetch('http://localhost:8080/api/galletas')
    const data = await response.json()
    return data
})

// Selector que devuelve el estado completo de las galletas
export const selectAllGalletas = state => state.galletas
