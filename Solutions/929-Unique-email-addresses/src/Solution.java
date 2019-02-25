import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String recent = emails[i];
            String[] parts = recent.split("@");
            String localName = parts[0];
            if (localName.contains("+")) {
                int location = localName.indexOf("+");
                localName = localName.substring(0, location);
            }
            if (localName.contains(".")) {
                String localNameNew = "";
                String[] localNameParts = localName.split("\\.");
                for (int j = 0; j < localNameParts.length; j++) {
                    localNameNew += localNameParts[j];
                }
                localName = localNameNew;
            }
            String email = localName + "@" + parts[1];
            set.add(email);
        }
        return set.size();
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String recent: emails) {
            int index = recent.indexOf("@");
            String localName = recent.substring(0, index);
            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf("+"));
            }
            localName = localName.replaceAll("\\.", "");
            String email = localName + recent.substring(index);
            set.add(email);
        }
        return set.size();
    }

    public static void main(String[] args) {
        //String[] emails = new String[]{"hfmeqzk.isx+i@fiidmdrsu.com"};
        String[] emails = new String[]{"j+ezsorqlmc@rfpycgjuf.com","j+k+ri+rigt.ad@rfpycgjuf.com","hfmeqzk.isx+i@fiidmdrsu.com","j+p+h+d+d+p+z.j.k.g@rfpycgjuf.com","zygekdy.l.w+s@snh.owpyu.com","j+m.l+ia+qdgv+w@rfpycgjuf.com","r+hwbjwefkp@wcjaki.n.com","zygekdy.l.w+d@snh.owpyu.com","bizdm+sz.f.a.k@il.cjjlp.com","hfmeqzk.isx+t@fiidmdrsu.com","hfmeqzk.isx+i@fiidmdrsu.com","bizdm+f+j+m.l.l@il.cjjlp.com","zygekdy.l.w+g@snh.owpyu.com","r+evgvxmksf@wcjaki.n.com","hfmeqzk.isx+h@fiidmdrsu.com","bizdm+lov+cy@il.cjjlp.com","hfmeqzk.isx+o@fiidmdrsu.com","bizdm+hs+qao@il.cjjlp.com","r+v+z+rcuznrj@wcjaki.n.com","j+r.kn+h.w.a.h+bh@rfpycgjuf.com","hfmeqzk.isx+t@fiidmdrsu.com","hfmeqzk.isx+a@fiidmdrsu.com","zygekdy.l.w+o@snh.owpyu.com","zygekdy.l.w+i@snh.owpyu.com","r+vy.u.y+f.er+aw@wcjaki.n.com","zygekdy.l.w+c@snh.owpyu.com","bizdm+wztzg@il.cjjlp.com","j+h.fwbsr+chp@rfpycgjuf.com","zygekdy.l.w+s@snh.owpyu.com","zygekdy.l.w+d@snh.owpyu.com","bizdm+qq.o.q+p@il.cjjlp.com","zygekdy.l.w+o@snh.owpyu.com","j+c+zqbq+h.dyt@rfpycgjuf.com","r+hl.b.i+fz.hz.t@wcjaki.n.com","r+cbabpf.k+w+e@wcjaki.n.com"};
        System.out.println(new Solution().numUniqueEmails2(emails));
    }
}
