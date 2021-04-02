package me.learn.personal.month7;

public class ConstructKPalindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// count the number of odds
	// ensure its always less than or equal to k
	public boolean canConstruct(String s, int k) {
		if (s == null || s.length() < k)
			return false;
		int odds = 0, cnt[] = new int[26];
		for (char c : s.toCharArray())
			cnt[c - 'a']++;
		for (int i = 0; i < 26; i++)
			odds += cnt[i] % 2;
		return odds <= k;
	}

}
