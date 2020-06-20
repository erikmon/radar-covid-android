package es.gob.covidradar.features.poll.completed.protocols

interface PollCompletedView {

    fun sendMailToSupport()

    fun showDialerForSupport()

    fun finish()

}

interface PollCompletedPresenter {

    fun viewReady()

    fun onMailButtonClick()

    fun onContactSupportButtonClick()

    fun onBackToMainButtonClick()

}