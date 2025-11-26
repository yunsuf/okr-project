import React, { useState } from 'react';
import { evaluateOkrs, generateOkr, createObjective } from '../services/api';

const AiAssistant = ({ objectives, onOkrGenerated }) => {
    const [evaluation, setEvaluation] = useState('');
    const [generationPrompt, setGenerationPrompt] = useState('');
    const [generatedOkr, setGeneratedOkr] = useState('');
    const [loading, setLoading] = useState(false);

    const handleEvaluate = async () => {
        setLoading(true);
        try {
            const response = await evaluateOkrs(objectives);
            setEvaluation(response.data);
        } catch (error) {
            console.error('Error evaluating OKRs:', error);
            setEvaluation('Error getting evaluation.');
        }
        setLoading(false);
    };

    const handleGenerate = async () => {
        setLoading(true);
        try {
            const response = await generateOkr(generationPrompt);
            setGeneratedOkr(response.data);
        } catch (error) {
            console.error('Error generating OKR:', error);
            setGeneratedOkr('Error generating OKR.');
        }
        setLoading(false);
    };

    return (
        <div className="bg-white p-6 rounded-lg shadow-md border border-purple-200">
            <h2 className="text-xl font-semibold mb-4 text-purple-700">AI Assistant</h2>

            {/* Evaluation Section */}
            <div className="mb-6">
                <h3 className="font-medium mb-2">OKR Evaluation</h3>
                <button
                    onClick={handleEvaluate}
                    disabled={loading}
                    className="bg-purple-500 text-white px-4 py-2 rounded hover:bg-purple-600 disabled:bg-purple-300"
                >
                    {loading ? 'Evaluating...' : 'Evaluate Current OKRs'}
                </button>
                {evaluation && (
                    <div className="mt-4 p-3 bg-gray-50 rounded text-sm whitespace-pre-wrap border">
                        {evaluation}
                    </div>
                )}
            </div>

            {/* Generation Section */}
            <div>
                <h3 className="font-medium mb-2">Generate OKR</h3>
                <textarea
                    placeholder="Describe your goal (e.g., 'Increase brand awareness')"
                    className="w-full p-2 border rounded mb-2"
                    value={generationPrompt}
                    onChange={(e) => setGenerationPrompt(e.target.value)}
                />
                <button
                    onClick={handleGenerate}
                    disabled={loading || !generationPrompt}
                    className="bg-indigo-500 text-white px-4 py-2 rounded hover:bg-indigo-600 disabled:bg-indigo-300"
                >
                    {loading ? 'Generating...' : 'Generate OKR Suggestion'}
                </button>
                {generatedOkr && (
                    <div className="mt-4 p-3 bg-gray-50 rounded text-sm whitespace-pre-wrap border">
                        {generatedOkr}
                    </div>
                )}
            </div>
        </div>
    );
};

export default AiAssistant;
