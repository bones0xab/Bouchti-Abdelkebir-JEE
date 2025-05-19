export interface Credit {
  id?: number
  montant: number
  duree: number
  taux: number
  dateDebut: string
  clientId: number
  type: string
}

export interface CreditPersonnel extends Credit {
  type: 'PERSONNEL'
  motif: string
}

export interface CreditProfessionnel extends Credit {
  type: 'PROFESSIONNEL'
  secteurActivite: string
}

export interface CreditImmobilier extends Credit {
  type: 'IMMOBILIER'
  adresseBien: string
  superficieBien: number
}
