package es.gob.radarcovid.features.helpline.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.gob.radarcovid.R
import es.gob.radarcovid.common.base.BaseFragment
import es.gob.radarcovid.features.helpline.protocols.HelplinePresenter
import es.gob.radarcovid.features.helpline.protocols.HelplineView
import kotlinx.android.synthetic.main.fragment_helpline.*
import javax.inject.Inject


class HelplineFragment : BaseFragment(), HelplineView {

    companion object {

        fun newInstance() = HelplineFragment()

    }

    @Inject
    lateinit var presenter: HelplinePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_helpline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        presenter.viewReady()
    }

    private fun initViews() {
        textViewFaqsWebUrl.setOnClickListener { presenter.onUrlButtonClick(textViewFaqsWebUrl.text.toString()) }
        textViewInfoWebUrl.setOnClickListener { presenter.onUrlButtonClick(textViewInfoWebUrl.text.toString()) }
        textViewOtherWebUrl.setOnClickListener { presenter.onUrlButtonClick(textViewOtherWebUrl.text.toString()) }
    }

    override fun showDialerForSupport() {
        startActivity(Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse(
                "tel:${labelManager.getContactPhone()}"
            )
        })
    }

    override fun sendMailToInterview() {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "plain/text"
            putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf(labelManager.getText("CONTACT_EMAIL", R.string.contact_email).toString())
            )
//            putExtra(Intent.EXTRA_SUBJECT, "Subject")
//            putExtra(Intent.EXTRA_TEXT, "Text")
        }

        startActivity(
            Intent.createChooser(
                emailIntent,
                "Send mail..."
            )
        )
    }

}