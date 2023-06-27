package com.example.prova1

class VacasLeiteiras(
    nome: String,
    cnpj: String,
    car: String,
    caixa: Float,
    val prodDiariaLitros: Float
): Fazenda(
    nome = nome,
    cnpj = cnpj,
    car = car,
    caixa = caixa
) {
    override fun toString(): String {
        return "VacasLeiteiras(prodDiariaLitros=$prodDiariaLitros)"
    }
}