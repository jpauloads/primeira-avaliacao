package com.example.prova1

open class Fazenda(
    val nome: String,
    val cnpj: String,
    val car: String,
    val caixa: Float
) {
    override fun toString(): String {
        return "Fazenda(nome='$nome', cnpj='$cnpj', car='$car', caixa=$caixa)"
    }
}