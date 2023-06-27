package com.example.prova1

class Porcos(
    val kgBacon: Float,
    nome: String,
    cnpj: String,
    car: String,
    caixa: Float
): Fazenda(
    nome = nome,
    cnpj = cnpj,
    car = car,
    caixa = caixa
) {
    override fun toString(): String {
        return "Porcos(kgBacon=$kgBacon)"
    }
}