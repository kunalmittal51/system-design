# Z-Test for Two Proportions: A Practical Guide

## Introduction

The Z-test for two proportions is a powerful statistical method used to determine whether the observed difference between two population proportions is statistically significant. This guide explains the method and provides a practical example using website conversion data.

## When to Use This Test

This test is appropriate when:
- You have two independent groups
- Each observation falls into one of two categories (success/failure, yes/no, etc.)
- You want to know if the proportion of successes differs between groups
- You have sufficiently large sample sizes

## The Method Explained

### Null and Alternative Hypotheses
- **Null Hypothesis (H₀)**: p₁ = p₂ (The proportions are equal)
- **Alternative Hypothesis (H₁)**: p₁ ≠ p₂ (The proportions are different)

Where p₁ and p₂ are the true population proportions for groups 1 and 2.

### Test Statistic
The Z-statistic is calculated as:

```
Z = (p̂₁ - p̂₂) / √[p̂(1-p̂)(1/n₁ + 1/n₂)]
```

Where:
- p̂₁ = x₁/n₁ (observed proportion in group 1)
- p̂₂ = x₂/n₂ (observed proportion in group 2)
- p̂ = (x₁ + x₂)/(n₁ + n₂) (pooled proportion)
- n₁, n₂ are the sample sizes

### Decision Rule
For a two-tailed test with α significance level:
- If |Z| > Z₍α/2₎, reject H₀
- If |Z| ≤ Z₍α/2₎, fail to reject H₀

Where Z₍α/2₎ is the critical Z-value for the chosen significance level.

## Practical Example: Website Conversion Analysis

### The Scenario
A company has implemented a new user flow on their website and wants to know if it improves conversion rates compared to the old flow.

### The Data
- **Old Flow**: 6,500 searches, 717 bookings
- **New Flow**: 616 searches, 82 bookings

### Step 1: Calculate Observed Proportions

Old flow conversion rate: p̂₁ = 717/6,500 = 0.1103 = 11.03%
New flow conversion rate: p̂₂ = 82/616 = 0.1331 = 13.31%

Observed difference: p̂₂ - p̂₁ = 0.1331 - 0.1103 = 0.0228 (2.28 percentage points)

### Step 2: Calculate Pooled Proportion

p̂ = (717 + 82)/(6,500 + 616) = 799/7,116 = 0.1123

### Step 3: Calculate the Z-Statistic

```
Z = (0.1331 - 0.1103) / √[0.1123(1-0.1123)(1/616 + 1/6,500)]
Z = 0.0228 / √[0.1123 × 0.8877 × (0.00162 + 0.00015)]
Z = 0.0228 / √[0.0997 × 0.00177]
Z = 0.0228 / √0.000177
Z = 0.0228 / 0.0133
Z ≈ 1.71
```

### Step 4: Determine Statistical Significance

For a 95% confidence level (α = 0.05), the critical Z-value for a two-tailed test is 1.96.

Since our calculated |Z| = 1.71 < 1.96, we fail to reject the null hypothesis at the 0.05 significance level.

For a 90% confidence level (α = 0.10), the critical Z-value is 1.645.
Since 1.71 > 1.645, the result would be significant at the 90% confidence level.

### Step 5: Interpret the Results

1. The new flow shows a 2.28 percentage point increase in conversion rate (a 20.67% relative improvement).
2. This difference is not statistically significant at the 95% confidence level, but it is significant at the 90% confidence level.
3. We are 90% confident that the observed improvement is real, but we cannot be 95% confident with the current sample size.

## Confidence Intervals

We can also calculate the 95% confidence interval for the difference in proportions:

```
CI = (p̂₁ - p̂₂) ± Z₍α/2₎ × √[p̂₁(1-p̂₁)/n₁ + p̂₂(1-p̂₂)/n₂]
```

For our example:
```
CI = (0.1103 - 0.1331) ± 1.96 × √[0.1103(1-0.1103)/6,500 + 0.1331(1-0.1331)/616]
CI = -0.0228 ± 1.96 × √[0.0981/6,500 + 0.1154/616]
CI = -0.0228 ± 1.96 × √[0.000015 + 0.000187]
CI = -0.0228 ± 1.96 × √0.000202
CI = -0.0228 ± 1.96 × 0.0142
CI = -0.0228 ± 0.0278
CI = (-0.0506, 0.0050)
```

Since this interval includes zero, it confirms that we cannot be 95% confident that the true difference is non-zero.

## Power Analysis

To determine if we have enough data, we can calculate the sample size needed for adequate statistical power:

```
n = (Zα/2 + Zβ)² × [p₁(1-p₁) + p₂(1-p₂)] / (p₁-p₂)²
```

For 80% power at 95% confidence to detect our observed difference:
```
n ≈ 3,220 per group
```

Since our new flow has only 616 users, we are underpowered for this analysis.

## Recommendations

1. **Continue testing**: Collect more data to achieve adequate statistical power.
2. **Consider practical significance**: A 20.67% relative improvement may be practically important even if not statistically significant at 95% confidence.
3. **Interim decision**: If business needs require a decision now, consider acting on the 90% confidence result with appropriate caution.
4. **Sequential testing**: Implement ongoing monitoring to update confidence as more data accumulates.

## Limitations

1. This test assumes random sampling or assignment.
2. Very small proportions or very unequal sample sizes may affect the accuracy.
3. The test doesn't account for other variables that might influence the outcomes.

## Summary

The Z-test for two proportions is a valuable tool for comparing conversion rates between different website designs, marketing campaigns, or product features. While statistical significance is important, always consider practical significance and business context when making decisions based on the results.
