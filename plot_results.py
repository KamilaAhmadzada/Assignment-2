import pandas as pd
import matplotlib.pyplot as plt

# Workload 1: Random Access
df1 = pd.read_csv("results/tables/workload1.csv")
plt.figure(figsize=(8,5))
for structure in df1["structure"].unique():
    sub = df1[df1["structure"] == structure]
    plt.plot(sub["n"], sub["timeMs"], marker="o", label=structure)
plt.xlabel("n"); plt.ylabel("Time (ms)")
plt.title("Workload 1: Random Access Time vs n")
plt.legend(); plt.grid(True)
plt.savefig("results/plots/workload1_time.png"); plt.close()

plt.figure(figsize=(8,5))
for structure in df1["structure"].unique():
    sub = df1[df1["structure"] == structure]
    plt.plot(sub["n"], sub["accesses"], marker="o", label=structure)
plt.xlabel("n"); plt.ylabel("Accesses")
plt.title("Workload 1: Node Accesses vs n")
plt.legend(); plt.grid(True)
plt.savefig("results/plots/workload1_accesses.png"); plt.close()

# Workload 2: Search
df2 = pd.read_csv("results/tables/workload2.csv")
plt.figure(figsize=(8,5))
for structure in df2["structure"].unique():
    sub = df2[df2["structure"] == structure]
    plt.plot(sub["n"], sub["timeMs"], marker="o", label=structure)
plt.xlabel("n"); plt.ylabel("Time (ms)")
plt.title("Workload 2: Search Time vs n")
plt.legend(); plt.grid(True)
plt.savefig("results/plots/workload2_time.png"); plt.close()

plt.figure(figsize=(8,5))
for structure in df2["structure"].unique():
    sub = df2[df2["structure"] == structure]
    plt.plot(sub["n"], sub["comparisons"], marker="o", label=structure)
plt.xlabel("n"); plt.ylabel("Comparisons")
plt.title("Workload 2: Comparisons vs n")
plt.legend(); plt.grid(True)
plt.savefig("results/plots/workload2_comparisons.png"); plt.close()

# Workload 3: Insertion/Removal
df3 = pd.read_csv("results/tables/workload3.csv")
plt.figure(figsize=(10,6))
for structure in df3["structure"].unique():
    for op in df3["operation"].unique():
        for pos in df3["position"].unique():
            sub = df3[(df3["structure"]==structure) & (df3["operation"]==op) & (df3["position"]==pos)]
            if not sub.empty:
                plt.plot(sub["n"], sub["timeMs"], marker="o", label=f"{structure}-{op}-{pos}")
plt.xlabel("n"); plt.ylabel("Time (ms)")
plt.title("Workload 3: Insertion/Removal Time vs n")
plt.legend(fontsize=8); plt.grid(True)
plt.savefig("results/plots/workload3_time.png"); plt.close()

# Workload 4: Priority Processing
df4 = pd.read_csv("results/tables/workload4.csv")
plt.figure(figsize=(8,5))
plt.plot(df4["n"], df4["insertTimeMs"], marker="o", label="Insert")
plt.plot(df4["n"], df4["extractTimeMs"], marker="o", label="Extract")
plt.xlabel("n"); plt.ylabel("Time (ms)")
plt.title("Workload 4: MinHeap Insert/Extract Time vs n")
plt.legend(); plt.grid(True)
plt.savefig("results/plots/workload4_time.png"); plt.close()

print("All plots saved to results/plots/")