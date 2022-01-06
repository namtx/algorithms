#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
            unordered_map<int, int> m;

            for (int i = 0; i < nums.size(); i++) {
                if (m[nums[i]] == 1) {
                    return true;
                }
                m[nums[i]]++;
            }

            return false;
    }
};

int main() {
        Solution s;
        vector<int> nums = {1, 2, 3, 1};
        cout << s.containsDuplicate(nums) << endl;

        return 0;
}
