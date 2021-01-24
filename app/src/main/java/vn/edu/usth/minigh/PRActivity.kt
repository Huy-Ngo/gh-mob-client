package vn.edu.usth.minigh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import vn.edu.usth.minigh.api.Issue
import vn.edu.usth.minigh.api.Pulls
import vn.edu.usth.minigh.api.github
import vn.edu.usth.minigh.fragments.IssuePrFragment
import vn.edu.usth.minigh.fragments.PullRequestFragment
import java.util.ArrayList

class PRActivity : BaseActivity(R.layout.activity_pr) {
    var frag: Fragment? = null
    var clickFrag: IssuePrFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val txt_toolbar = findViewById<View>(R.id.main_text_bar) as TextView
        txt_toolbar.text = "Pull Requests"
        val layout = findViewById<LinearLayout>(R.id.prs)
        layout.setBackgroundColor(applicationContext.resources.getColor(R.color.secondaryColor))
        val sg = findViewById<View>(R.id.segmented2) as RadioGroup
        sg.check(R.id.button31)
        lifecycleScope.launch {
            val prOpen = github.prUser("author:"+"Huy-Ngo"+" state:open  is:pull-request")
            val igOpen: java.util.ArrayList<Pulls> = prOpen.items
            val prClose = github.prUser("author:"+"Huy-Ngo"+" state:closed  is:pull-request")
            val igClose: java.util.ArrayList<Pulls> = prClose.items
            addFrag("Open", igOpen.count(), igOpen!!)
            sg.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.button32 -> addFrag("Closed", igClose.count(), igClose!!)
                    else -> addFrag("Open", igOpen.count(), igOpen!!)
                }
            }
        }
    }

    fun addFrag(txt: String?, number: Int, ig: ArrayList<Pulls>) {
        val fm = supportFragmentManager
        frag = fm.findFragmentById(R.id.prsFragment)
        val ft = fm.beginTransaction()
        frag = PullRequestFragment.newInstance(txt, number, ig)
        ft.replace(R.id.prsFragment, frag as PullRequestFragment)
        ft.commit()
    }

    fun goToDiscuss(view: View) {
        val intent = Intent(this, DiscussionActivity::class.java)
        //        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        val title = view.findViewById<View>(R.id.issuePrGhname) as TextView
        intent.putExtra("title", title.text as String)
        val description = view.findViewById<View>(R.id.issuePrContent) as TextView
        intent.putExtra("description", description.text)
        startActivity(intent)
    }
}