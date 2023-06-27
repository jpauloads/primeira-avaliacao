package com.example.prova1

class Lavoura(
    nome: String,
    cnpj: String,
    caixa: Float,
    car: String,
    val silo: Boolean
) : Fazenda(
    nome = nome,
    cnpj = cnpj,
    caixa = caixa,
    car = car
){

    override fun toString(): String {
        return "Lavoura(silo=$silo)"
    }
}