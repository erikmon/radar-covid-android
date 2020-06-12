package com.indra.coronaradar.features.onboarding.pages.legal.protocols

interface LegalInfoView {

    fun showCheckWarning()

    fun hideCheckWarning()

    fun setContinueButtonEnabled(enabled: Boolean)

}

interface LegalInfoPresenter {

    fun viewReady()

    fun onLegalTermsButtonClick()

    fun onLegalTermsCheckedChange(checked: Boolean)

}

interface LegalInfoRouter {

    fun navigateToLegalInfoDetail()

}